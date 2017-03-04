package org.javalite.activejdbc;

import org.junit.Test;

import org.javalite.activejdbc.test.ActiveJDBCTest;
import org.javalite.activejdbc.test_models.Computer;
import org.javalite.activejdbc.test_models.Keyboard;
import org.javalite.activejdbc.test_models.Motherboard;

public class BelongsToParentsTest extends ActiveJDBCTest {

	@Override
    public void before() throws Exception { 
		super.before();

        deleteFromTable("computers");
        deleteFromTable("motherboards");
        deleteFromTable("keyboards");

        populateTable("motherboards");
        populateTable("keyboards");
        populateTable("computers");
	}
	
	@Test
	public void shouldCheckThatComputerBelongsTo2DifferentParents() { 
		Computer computer = Computer.findById(1);
		a(computer.parent(Motherboard.class)).shouldNotBeNull();
		a(computer.parent(Keyboard.class)).shouldNotBeNull();
	}
}

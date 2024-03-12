package com.acme.todolist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Instant;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import com.acme.todolist.domain.TodoItem;

@SpringBootTest
@SpringBootConfiguration
@SpringBootTest
class ApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	public void TodoItemLate() {
		//Test avec une tache ayant 25h de retard
		TodoItem testLate = new TodoItem("01", Instant.now().minusSeconds(90000), "Faire le ménage");
		assertEquals("[LATE!] Faire le ménage", testLate.finalContent());
		//Test avec une tache n'ayant aucun retard
		TodoItem testInTime = new TodoItem("02", Instant.now(), "Faire la vaisselle");
		assertEquals("Faire la vaisselle", testInTime.finalContent());
	}
}

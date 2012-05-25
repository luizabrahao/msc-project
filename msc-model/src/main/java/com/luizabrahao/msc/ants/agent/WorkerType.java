package com.luizabrahao.msc.ants.agent;

import java.util.ArrayList;
import java.util.List;

import net.jcip.annotations.ThreadSafe;

import com.luizabrahao.msc.model.agent.AbstractAgentType;
import com.luizabrahao.msc.model.task.Task;
import com.luizabrahao.msc.model.task.WandererTask;

/**
 * Represents a ant from the Worker cast.
 * 
 * @author Luiz Abrahao <luiz@luizabrahao.com>
 *
 */

@ThreadSafe
public class WorkerType extends AbstractAgentType {
	public static final String NAME = "worker";
	private static WorkerType instance = new WorkerType();
	private final List<Task> tasks;
	
	public WorkerType() {
		this.tasks = new ArrayList<Task>();
		tasks.add(new WandererTask());
	}

	@Override
	public List<Task> getTasks() { return this.tasks; }

	public static WorkerType getInstance() { return instance; }	
}
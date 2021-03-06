package com.luizabrahao.msc.ants.env;

import java.util.List;

import net.jcip.annotations.ThreadSafe;

import com.luizabrahao.msc.model.agent.TaskAgentType;
import com.luizabrahao.msc.model.task.Task;

/**
 * Declares the agnet type for food sources.
 * 
 * @author Luiz Abrahao <luiz@luizabrahao.com>
 *
 */

@ThreadSafe
public enum FoodSourceAgentType implements TaskAgentType {
	TYPE;
	
	private final String name = "type:ant:food-source";

	@Override
	public String getName() { return name; }

	@Override public List<Task> getTasks() { return null; }
}

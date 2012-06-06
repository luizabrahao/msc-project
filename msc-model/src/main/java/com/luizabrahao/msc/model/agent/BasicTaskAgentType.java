package com.luizabrahao.msc.model.agent;

import java.util.ArrayList;
import java.util.List;

import com.luizabrahao.msc.model.task.Task;
import com.luizabrahao.msc.model.task.WandererTask;

import net.jcip.annotations.ThreadSafe;

/**
 * This is the reference implementation of a concrete AgentType. As required
 * for any concrete AgentType, it is thread-safe and declares the public static
 * final field NAME. 
 * 
 * Note also that the agent employs the singleton pattern.  
 * 
 * This AgentType only has the WandererTask in its list and should be used in
 * unit tests and as a reference when building more complex and domain specific
 * agent types.
 * 
 * @author Luiz Abrahao <luiz@luizabrahao.com>
 *
 */
@ThreadSafe
public class BasicTaskAgentType extends AbstractAgentType implements TaskAgentType {
	public static final String NAME = "basic-agent";
	private static BasicTaskAgentType instance = new BasicTaskAgentType();
	private final List<Task> tasks;
	
	public BasicTaskAgentType() {
		tasks = new ArrayList<Task>();
		tasks.add(new WandererTask());
	}
	
	@Override
	public List<Task> getTasks() { return this.tasks; }
	
	public static BasicTaskAgentType getIntance() { return instance; }

	@Override
	public String getName() { return BasicTaskAgentType.NAME; }
}
package com.luizabrahao.msc.ants.agent;

import net.jcip.annotations.GuardedBy;

import com.luizabrahao.msc.model.agent.TaskAgent;
import com.luizabrahao.msc.model.agent.TaskAgentType;
import com.luizabrahao.msc.model.env.Direction;
import com.luizabrahao.msc.model.env.Node;

/**
 * Defines an agent that represents a ant. The movingDirection field represents
 * the direction the agent is moving in relation to the grid of nodes. This
 * direction is used when the algorithm is calculating the probabilities of the
 * agent selecting what node it will move next.
 * 
 * @author Luiz Abrahao <luiz@luizabrahao.com>
 * @see ForageTask
 *
 */
public class AntAgent extends TaskAgent {
	@GuardedBy("this") private Direction movingDirection;

	public synchronized Direction getMovingDirection() { return movingDirection; }
	public synchronized void setMovingDirection(Direction movingDirection) { this.movingDirection = movingDirection; }

	public AntAgent(String id, TaskAgentType agentType, Node currentNode, boolean recordNodeHistory) {
		super(id, agentType, currentNode, recordNodeHistory);
	}

	@Override
	public Void call() throws Exception {
		// Running with FORAGE only for now.
		this.getTaskList().get(0).execute(this);
		return null;
	}
}

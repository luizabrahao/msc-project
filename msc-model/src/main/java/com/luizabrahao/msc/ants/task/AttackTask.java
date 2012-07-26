package com.luizabrahao.msc.ants.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.luizabrahao.msc.ants.agent.AntAgent;
import com.luizabrahao.msc.ants.env.WarningStimulusType;
import com.luizabrahao.msc.ants.env.ForageStimulusType;
import com.luizabrahao.msc.model.agent.Agent;
import com.luizabrahao.msc.model.env.Direction;
import com.luizabrahao.msc.model.env.Node;
import com.luizabrahao.msc.model.task.AbstractTask;

public class AttackTask extends AbstractTask implements AntTask {
	private static final Logger logger = LoggerFactory.getLogger(AttackTask.class);
	private static final long milisecondsToWait = 5;
	public static final String NAME = "ant:task:attack";
	private static final double weight_north = 0.30;
	private static final double weight_east = 0.30;
	private static final double weight_south = 0.10;
	private static final double weight_west = 0.30;
	
	public AttackTask() {
		super(AttackTask.NAME);
	}

	@Override public double getNeighbourWeightNorth() { return weight_north; }
	@Override public double getNeighbourWeightEast() { return weight_east; }
	@Override public double getNeighbourWeightSouth() { return weight_south; }
	@Override public double getNeighbourWeightWest() { return weight_west; }
	
	@Override
	public void execute(Agent agent) {
		AntAgent a = (AntAgent) agent;
		Direction d = AntTaskUtil.getDirectionToMoveTo(a, ForageStimulusType.TYPE, weight_north, weight_east, weight_south, weight_west);
		
		Node nodeToMoveTo = agent.getCurrentNode().getNeighbour(d);
		a.incrementStimulusIntensity(WarningStimulusType.TYPE);

		nodeToMoveTo.addAgent(agent);

		try {
			Thread.sleep(milisecondsToWait);
		} catch (InterruptedException e) {
			logger.trace("Agent '{}' interrupted while waiting.", agent.getId());
		}
	}
}

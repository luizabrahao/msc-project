package com.luizabrahao.msc.ants.render;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.luizabrahao.msc.ants.agent.WorkerType;
import com.luizabrahao.msc.ants.env.AntEnvironmentFactory;
import com.luizabrahao.msc.ants.env.PheromoneNode;
import com.luizabrahao.msc.model.agent.TaskAgent;
import com.luizabrahao.msc.model.agent.TaskAgentType;
import com.luizabrahao.msc.model.env.Node;

public class RenderAgentFactoryTest {
	private class MockTaskAgent extends TaskAgent {
		public MockTaskAgent(String id, TaskAgentType agentType, Node currentNode) {
			super(id, agentType, currentNode);
		}

		@Override
		public void run() {
			this.getTaskList().get(0).execute(this);
		}
	}
	
	
	@Test @SuppressWarnings("unused")
	public void exploredSpaceTest() throws InterruptedException {
		int nLines = 250;
		int nColumns = 200;
		PheromoneNode[][] grid = AntEnvironmentFactory.createPheromoneNodeGrid(nLines, nColumns);
		
		TaskAgent a01 = new MockTaskAgent("a-01", WorkerType.getInstance(), grid[0][0]);
		TaskAgent a02 = new MockTaskAgent("a-02", WorkerType.getInstance(), grid[0][10]);
		TaskAgent a03 = new MockTaskAgent("a-03", WorkerType.getInstance(), grid[0][20]);
		TaskAgent a04 = new MockTaskAgent("a-04", WorkerType.getInstance(), grid[0][30]);
		TaskAgent a05 = new MockTaskAgent("a-05", WorkerType.getInstance(), grid[0][40]);
		TaskAgent a06 = new MockTaskAgent("a-06", WorkerType.getInstance(), grid[0][50]);
		TaskAgent a07 = new MockTaskAgent("a-07", WorkerType.getInstance(), grid[0][60]);
		TaskAgent a08 = new MockTaskAgent("a-08", WorkerType.getInstance(), grid[0][70]);
		TaskAgent a09 = new MockTaskAgent("a-09", WorkerType.getInstance(), grid[0][80]);
		TaskAgent a10 = new MockTaskAgent("a-10", WorkerType.getInstance(), grid[0][90]);
		
		ExecutorService executor = Executors.newFixedThreadPool(15);
		executor.execute(a01);
		executor.execute(a02);
		executor.execute(a03);
		executor.execute(a04);
		executor.execute(a05);
		executor.execute(a06);
		executor.execute(a07);
		executor.execute(a08);
		executor.execute(a09);
		executor.execute(a10);
		
		List<Callable<Object>> tasks = new ArrayList<Callable<Object>>();
		tasks.add(Executors.callable(RenderAgentFactory.getExploredSpaceRenderer("target/explored-space.png", grid, nLines, nColumns)));
		
		final List<Future<Object>> futures = executor.invokeAll(tasks);
	}
	
	
	@Test @SuppressWarnings("unused")
	public void populationTest() throws InterruptedException {
		int nLines = 250;
		int nColumns = 200;
		PheromoneNode[][] grid = AntEnvironmentFactory.createPheromoneNodeGrid(nLines, nColumns);
		
		TaskAgent a01 = new MockTaskAgent("a-01", WorkerType.getInstance(), grid[0][0]);
		TaskAgent a02 = new MockTaskAgent("a-02", WorkerType.getInstance(), grid[0][10]);
		TaskAgent a03 = new MockTaskAgent("a-03", WorkerType.getInstance(), grid[0][20]);
		TaskAgent a04 = new MockTaskAgent("a-04", WorkerType.getInstance(), grid[0][30]);
		TaskAgent a05 = new MockTaskAgent("a-05", WorkerType.getInstance(), grid[0][40]);
		TaskAgent a06 = new MockTaskAgent("a-06", WorkerType.getInstance(), grid[0][50]);
		TaskAgent a07 = new MockTaskAgent("a-07", WorkerType.getInstance(), grid[0][60]);
		TaskAgent a08 = new MockTaskAgent("a-08", WorkerType.getInstance(), grid[0][70]);
		TaskAgent a09 = new MockTaskAgent("a-09", WorkerType.getInstance(), grid[0][80]);
		TaskAgent a10 = new MockTaskAgent("a-10", WorkerType.getInstance(), grid[0][90]);
		
		ExecutorService executor = Executors.newFixedThreadPool(15);
		executor.execute(a01);
		executor.execute(a02);
		executor.execute(a03);
		executor.execute(a04);
		executor.execute(a05);
		executor.execute(a06);
		executor.execute(a07);
		executor.execute(a08);
		executor.execute(a09);
		executor.execute(a10);
		
		List<Callable<Object>> tasks = new ArrayList<Callable<Object>>();
		tasks.add(Executors.callable(RenderAgentFactory.getPopulationRenderer("target/population.png", grid, nLines, nColumns)));
		
		ExecutorService renderExecutor = Executors.newFixedThreadPool(1);
		final List<Future<Object>> futures = renderExecutor.invokeAll(tasks);
	}
	
	@Test @SuppressWarnings("unused")
	public void pheromoneTest() throws InterruptedException {
		int nLines = 250;
		int nColumns = 200;
		PheromoneNode[][] grid = AntEnvironmentFactory.createPheromoneNodeGrid(nLines, nColumns);
			
		TaskAgent a01 = new MockTaskAgent("a-01", WorkerType.getInstance(), grid[0][0]);
		TaskAgent a02 = new MockTaskAgent("a-02", WorkerType.getInstance(), grid[0][10]);
		TaskAgent a03 = new MockTaskAgent("a-03", WorkerType.getInstance(), grid[0][20]);
		TaskAgent a04 = new MockTaskAgent("a-04", WorkerType.getInstance(), grid[0][30]);
		TaskAgent a05 = new MockTaskAgent("a-05", WorkerType.getInstance(), grid[0][40]);
		TaskAgent a06 = new MockTaskAgent("a-06", WorkerType.getInstance(), grid[0][50]);
		TaskAgent a07 = new MockTaskAgent("a-07", WorkerType.getInstance(), grid[0][60]);
		TaskAgent a08 = new MockTaskAgent("a-08", WorkerType.getInstance(), grid[0][70]);
		TaskAgent a09 = new MockTaskAgent("a-09", WorkerType.getInstance(), grid[0][80]);
		TaskAgent a10 = new MockTaskAgent("a-10", WorkerType.getInstance(), grid[0][90]);
		
		List<Callable<Object>> tasks = new ArrayList<Callable<Object>>();
		final ScheduledExecutorService executor = Executors.newScheduledThreadPool(15);
		
		tasks.add(Executors.callable(a01));
		tasks.add(Executors.callable(a02));
		tasks.add(Executors.callable(a03));
		tasks.add(Executors.callable(a04));
		tasks.add(Executors.callable(a05));
		tasks.add(Executors.callable(a06));
		tasks.add(Executors.callable(a07));
		tasks.add(Executors.callable(a08));
		tasks.add(Executors.callable(a09));
		tasks.add(Executors.callable(a10));
		
		executor.schedule(RenderAgentFactory.getExploredSpaceRenderer("target/explored-space-phero.png", grid, nLines, nColumns), 10000, TimeUnit.MILLISECONDS);
		
		final List<Future<Object>> futures = executor.invokeAll(tasks);
		
		executor.schedule(new Runnable(){
		     public void run(){
		        for (int i = 0; i < futures.size(); i++) {
		        	futures.get(i).cancel(true);
		        }
		     }      
		 }, 10000, TimeUnit.MILLISECONDS);

		
		
		
		for (int l = 0; l < nLines; l++) {
			for (int c = 0; c < nColumns; c++) {
				(grid[l][c]).setPheromoneIntensity(0.1);
			}
		}
		
		for (int l = 15; l < 30; l++) {
			for (int c = 25; c < 175; c++) {
				(grid[l][c]).setPheromoneIntensity(0.2);
			}
		}
		
		for (int l = 30; l < 45; l++) {
			for (int c = 50; c < 150; c++) {
				(grid[l][c]).setPheromoneIntensity(0.4);
			}
		}
		
		for (int l = 45; l < 60; l++) {
			for (int c = 75; c < 125; c++) {
				(grid[l][c]).setPheromoneIntensity(0.6);
			}
		}				
	}
}
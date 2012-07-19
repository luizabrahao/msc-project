package com.luizabrahao.msc.ants.env;

public enum AttackStimulusType implements ChemicalCommStimulusType {
	TYPE;

	private static final String name = "ant:env:stimulus:attac";
	private static final double decay_factor = 0.2;
	private static final int radius = 2;
	
	@Override public String getName() { return name; }
	@Override public double getDecayFactor() { return decay_factor; }
	@Override public int getRadius() { return radius; }
}

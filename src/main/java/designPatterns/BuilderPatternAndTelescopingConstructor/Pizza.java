package designPatterns.BuilderPatternAndTelescopingConstructor;

public class Pizza {
	  private int size;
	  private boolean cheese;
	  private boolean pepperoni;
	  private boolean bacon;

	  public static class Builder {
	    //required
	    private final int size;

	    //optional
	    private boolean cheese = false;
	    private boolean pepperoni = false;
	    private boolean bacon = false;

	    public Builder(int size) {
	      this.size = size;
	    }

	    public Builder setCheese(boolean value) {
	      cheese = value;
	      return this;
	    }

	    public Builder setPepperoni(boolean value) {
	      pepperoni = value;
	      return this;
	    }

	    public Builder setBacon(boolean value) {
	      bacon = value;
	      return this;
	    }

	    public Pizza build() {
	      return new Pizza(this);
	    }
	  }

	  private Pizza(Builder builder) {
	    size = builder.size;
	    cheese = builder.cheese;
	    pepperoni = builder.pepperoni;
	    bacon = builder.bacon;
	  }
	}
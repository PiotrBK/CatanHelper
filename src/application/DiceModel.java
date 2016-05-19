package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class DiceModel {

	 	
	IntegerProperty value;
	
	public final int getValue() {
		if(value != null)
			return value.get();
		return 0;
	}
	
	public final void setValue(int value) {
		this.integerProperty().set(value); 
	}
	
	public final IntegerProperty integerProperty(){
		if(value == null){
			value = new SimpleIntegerProperty(1);
			return value;
		}
		return value;
		
	}
	
}

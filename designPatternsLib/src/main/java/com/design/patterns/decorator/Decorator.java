package com.design.patterns.decorator;

public  abstract class Decorator extends Component{
    private Component mComponent;


    public Decorator(Component mComponent) {
        this.mComponent = mComponent;
    }

    @Override
    void attackMagic() {
        mComponent.attackMagic();
    }
}

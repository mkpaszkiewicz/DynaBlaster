package paszkiewicz.marcin.util;

import paszkiewicz.marcin.view.graphic.bonus.Bonus;

public interface GameObjectVisitor
{
    // public void visit(Bomb bomb);
    //
    // public void visit(FallingWall fallingWall);
    //
    public void visit(Bonus bonus);
    //
    // public void visit(Explosion explosion);
}

package paszkiewicz.marcin.model.map;

import java.util.HashMap;

import paszkiewicz.marcin.util.Command;
import paszkiewicz.marcin.util.factory.AnimatatedGraphicPrototypeFactory;
import paszkiewicz.marcin.util.factory.BonusPrototypeFactory;
import paszkiewicz.marcin.util.factory.SpriteFactory;

public class TileIdToFactoryMethodMapper
{
    public static java.util.Map<Integer, Command> map = new HashMap<Integer, Command>();

    static
    {
        map.put(TileId.NEXT_STAGE, new Command() {
            public Object run()
            {
                return AnimatatedGraphicPrototypeFactory.createNextStage();
            };
        });
        
        map.put(TileId.WALL, new Command() {
            public Object run()
            {
                return AnimatatedGraphicPrototypeFactory.createWall();
            };
        });
        
        map.put(TileId.DEATH, new Command() {
            public Object run()
            {
                return BonusPrototypeFactory.createDeath();
            };
        });
        map.put(TileId.EXTRA_BOMB, new Command() {
            public Object run()
            {
                return BonusPrototypeFactory.createExtraBomb();
            };
        });
        map.put(TileId.EXTRA_LIFE, new Command() {
            public Object run()
            {
                return BonusPrototypeFactory.createExtraLife();
            };
        });
        map.put(TileId.EXTRA_RANGE, new Command() {
            public Object run()
            {
                return BonusPrototypeFactory.createExtraRange();
            };
        });
        map.put(TileId.EXTRA_SPEED, new Command() {
            public Object run()
            {
                return BonusPrototypeFactory.createExtraSpeed();
            };
        });
        map.put(TileId.REMOVE_BOMB, new Command() {
            public Object run()
            {
                return BonusPrototypeFactory.createRemoveBomb();
            };
        });
        map.put(TileId.REMOVE_RANGE, new Command() {
            public Object run()
            {
                return BonusPrototypeFactory.createRemoveRange();
            };
        });
        map.put(TileId.REMOVE_SPEED, new Command() {
            public Object run()
            {
                return BonusPrototypeFactory.createRemoveSpeed();
            };
        });
        map.put(TileId.BALLOON, new Command() {
            public Object run()
            {
                return SpriteFactory.createBalloon();
            };
        });
        map.put(TileId.GHOST, new Command() {
            public Object run()
            {
                return SpriteFactory.createGhost();
            };
        });
        map.put(TileId.BROOM, new Command() {
            public Object run()
            {
                return SpriteFactory.createBroom();
            };
        });
        map.put(TileId.PUMP, new Command() {
            public Object run()
            {
                return SpriteFactory.createPump();
            };
        });
        map.put(TileId.STAIN, new Command() {
            public Object run()
            {
                return SpriteFactory.createStain();
            };
        });
    }
}

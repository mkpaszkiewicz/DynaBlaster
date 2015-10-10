package paszkiewicz.marcin.model.game.map;

import java.util.HashMap;

import paszkiewicz.marcin.util.BonusPrototypeFactory;
import paszkiewicz.marcin.util.Command;

public class TileIdToFactoryMethodMapper
{
    public static java.util.Map<Integer, Command> map = new HashMap<Integer, Command>();

    static
    {
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
    }
}

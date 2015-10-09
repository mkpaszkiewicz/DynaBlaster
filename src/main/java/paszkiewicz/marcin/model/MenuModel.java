package paszkiewicz.marcin.model;

import paszkiewicz.marcin.menu.Menu;

public interface MenuModel
{
    Menu getMenu();
    
    void initMenu();
    
    void disableMenuField(String name);

    void enableMenuField(String name);
}

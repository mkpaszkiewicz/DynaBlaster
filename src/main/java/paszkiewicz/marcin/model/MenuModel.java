package paszkiewicz.marcin.model;

import paszkiewicz.marcin.component.menu.Menu;

public interface MenuModel
{
    Menu getMenu();
    
    void initMenu();
    
    void disableMenuField(String name);

    void enableMenuField(String name);
}

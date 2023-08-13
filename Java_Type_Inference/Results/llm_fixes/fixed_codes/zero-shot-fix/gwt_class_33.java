import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class gwt_class_33 implements EntryPoint {
    private DockPanel panel;
    private List<CheckBox> clearables;

    public void onModuleLoad() {
        clearables = new ArrayList<>();
        initDockPanel();
        panel.add(buildActionPanel(), DockPanel.SOUTH);
        panel.add(buildPizzaTypePanel(), DockPanel.WEST);
        panel.add(buildToppingPanel(), DockPanel.EAST);
        RootPanel.get("slicr").add(panel);
    }

    private void initDockPanel() {
        panel = new DockPanel();
        panel.setBorderWidth(1);
        panel.setSpacing(5);
    }

    public HorizontalPanel buildActionPanel() {
        HorizontalPanel actions = new HorizontalPanel();
        actions.setSpacing(10);
        Button clear = new Button("Clear");
        clear.addClickHandler(new ClearClickHandler());
        Button newPizza = new Button("Another Pizza");
        Button submitOrder = new Button("Submit");
        actions.add(clear);
        actions.add(newPizza);
        actions.add(submitOrder);
        return actions;
    }

    public static final String[] PIZZA_TYPES = new String[] {
            "Thin Crust Medium", "Thin Crust Large",
            "Thin Crust X-Large", "Thick Crust Medium",
            "Thick Crust Large"
    };

    private VerticalPanel buildPizzaTypePanel() {
        VerticalPanel pizzaTypes = new VerticalPanel();
        HTML label = new HTML("<h2>Pizza</h2>");
        pizzaTypes.add(label);
        for (int i = 0; i < PIZZA_TYPES.length; i++) {
            RadioButton radio = new RadioButton("pizzaGroup",
                    PIZZA_TYPES[i]);
            clearables.add(radio);
            pizzaTypes.add(radio);
        }
        return pizzaTypes;
    }

    public static final String[] TOPPINGS = new String[] {
            "Anchovy", "Gardineria", "Garlic",
            "Green Pepper", "Mushrooms", "Olives",
            "Onions", "Pepperoni", "Pineapple",
            "Sausage", "Spinach"
    };

    private VerticalPanel buildToppingPanel() {
        VerticalPanel toppings = new VerticalPanel();
        toppings.add(new HTML("<h2>Toppings</h2>"));
        Grid topGrid = new Grid(TOPPINGS.length + 1, 3);
        topGrid.setText(0, 0, "Topping");
        topGrid.setText(0, 1, "Left");
        topGrid.setText(0, 2, "Right");
        for (int i = 0; i < TOPPINGS.length; i++) {
            Button button = new Button(TOPPINGS[i]);
            CheckBox leftCheckBox = new CheckBox();
            CheckBox rightCheckBox = new CheckBox();
            clearables.add(leftCheckBox);
            clearables.add(rightCheckBox);
            button.addClickHandler(new ToppingButtonClickHandler(
                    leftCheckBox, rightCheckBox));
            topGrid.setWidget(i + 1, 0, button);
            topGrid.setWidget(i + 1, 1, leftCheckBox);
            topGrid.setWidget(i + 1, 2, rightCheckBox);
        }
        toppings.add(topGrid);
        return toppings;
    }

    private class ClearClickHandler implements ClickHandler {
        public void onClick(ClickEvent event) {
            for (Iterator<CheckBox> iter = clearables.iterator(); iter.hasNext();) {
                CheckBox cb = iter.next();
                cb.setValue(false);
            }
        }
    }

    private class ToppingButtonClickHandler implements ClickHandler {

        private CheckBox cb1;
        private CheckBox cb2;

        public ToppingButtonClickHandler(CheckBox cb1, CheckBox cb2) {
            this.cb1 = cb1;
            this.cb2 = cb2;
        }

        public void onClick(ClickEvent event) {
            boolean unchecked = !cb1.getValue() && !cb2.getValue();
            cb1.setValue(unchecked);
            cb2.setValue(unchecked);
        }
    }
}
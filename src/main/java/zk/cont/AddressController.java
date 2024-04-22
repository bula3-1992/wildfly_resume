package zk.cont;


import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.*;
import zk.ent.Address;

import java.util.Set;

public class AddressController extends SelectorComposer<Component> {

    private static final long serialVersionUID = 1L;

    @Wire
    private Textbox keywordBox;
    @Wire
    private Listbox addressListbox;
    @Wire
    private Label indexLabel;
    @Wire
    private Label cityLabel;
    @Wire
    private Label streetLabel;
    @Wire
    private Label numberLabel;
    @Wire
    private Label aptLabel;

    private ListModelList<Address> dataModel = new ListModelList<>();
    private AddressService addressService = new AddressServiceImpl();

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        addressListbox.setModel(dataModel);
    }

    @Listen("onClick = #searchButton; onOK = window")
    public void search() {
        String keyword = keywordBox.getValue();
        dataModel.clear();
        dataModel.addAll(addressService.search(keyword));
    }

    @Listen("onSelect = #addressListbox")
    public void showDetail() {
        Set<Address> selection = dataModel.getSelection();
        Address selected = selection.iterator().next();
        indexLabel.setValue(selected.getIndex());
        cityLabel.setValue(selected.getCity());
        streetLabel.setValue(selected.getStreet());
        numberLabel.setValue(selected.getHomeNumber());
        aptLabel.setValue(selected.getApartment());
    }
}

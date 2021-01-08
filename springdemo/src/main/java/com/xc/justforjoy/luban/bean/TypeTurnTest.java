package com.xc.justforjoy.luban.bean;

import com.xc.justforjoy.entity.User;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;

/**
 * @author lxcecho
 * @since 2021/1/8
 */
public class TypeTurnTest {
	public static void main(String[] args) {
		StringToUserPropertyEditor stringToUserPropertyEditor = new StringToUserPropertyEditor();
		stringToUserPropertyEditor.setAsText("1");
		User value = (User) stringToUserPropertyEditor.getValue();
		System.out.println(value);
	}
}

class StringToUserPropertyEditor extends PropertyEditorSupport implements PropertyEditor {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		User user = new User();
		user.setName(text);
		this.setValue(user);
	}
}

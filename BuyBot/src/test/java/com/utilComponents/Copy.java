package com.utilComponents;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class Copy {

    public static void copypath(String text) {
        Clipboard clipboard = getSystemClipboard();
        clipboard.setContents(new StringSelection(text), null);
    }

    private static Clipboard getSystemClipboard() {
        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        Clipboard systemClipboard = defaultToolkit.getSystemClipboard();

        return systemClipboard;
    }

}

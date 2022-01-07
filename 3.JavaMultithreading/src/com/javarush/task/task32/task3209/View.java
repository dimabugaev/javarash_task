package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.*;
//import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
//import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);

    public View() throws HeadlessException {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }

    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Новый":
                controller.createNewDocument();
                break;
            case "Открыть":
                controller.openDocument();
                break;
            case "Сохранить":
                controller.saveDocument();
                break;
            case "Сохранить как...":
                controller.saveDocumentAs();
                break;
            case "Выход":
                controller.exit();
                break;
            case "О программе":
                showAbout();
                break;
        }
    }

    public void exit(){
        controller.exit();
    }

    public void init(){
        initGui();
        FrameListener frameListener = new FrameListener(this);
        addWindowListener(frameListener);
        setVisible(true);
    }

    public void initMenuBar(){
        JMenuBar menuBar = new JMenuBar();
        MenuHelper.initFileMenu(this, menuBar);
        MenuHelper.initEditMenu(this, menuBar);
        MenuHelper.initStyleMenu(this, menuBar);
        MenuHelper.initAlignMenu(this, menuBar);
        MenuHelper.initColorMenu(this, menuBar);
        MenuHelper.initFontMenu(this, menuBar);
        MenuHelper.initHelpMenu(this, menuBar);
        getContentPane().add(menuBar,BorderLayout.NORTH);
        //menuBar.add(MenuHelper.)
    }

    public void initEditor(){
        htmlTextPane.setContentType("text/html");
        JScrollPane jScrollPaneHTML = new JScrollPane(htmlTextPane);
        tabbedPane.add("HTML", jScrollPaneHTML);
        JScrollPane jScrollPaneText = new JScrollPane(plainTextPane);
        tabbedPane.add("Текст", jScrollPaneText);
        tabbedPane.setPreferredSize(null);
        tabbedPane.addChangeListener(new TabbedPaneChangeListener(this));
        getContentPane().add(tabbedPane,BorderLayout.CENTER);
        //addChangeListener()
    }

    public void initGui(){
        initMenuBar();
        initEditor();
        pack();
    }
    public boolean canUndo(){
        return undoManager.canUndo();
    }

    public boolean canRedo(){
        return undoManager.canRedo();
    }

    public void undo(){
        try {
            undoManager.undo();
        } catch (CannotUndoException e) {
            ExceptionHandler.log(e);
        }
    }

    public void redo(){
        try {
            undoManager.redo();
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public UndoListener getUndoListener() {
        return undoListener;
    }

    public void resetUndo(){
        undoManager.discardAllEdits();
    }

    public boolean isHtmlTabSelected(){
        return tabbedPane.getSelectedIndex() == 0;
    }

    public void selectHtmlTab(){
        tabbedPane.setSelectedIndex(0);
        resetUndo();
    }

    public void update(){
        htmlTextPane.setDocument(controller.getDocument());
    }

    public void showAbout(){
        JOptionPane.showMessageDialog(tabbedPane, "this program develop from task JAVA\n by boogie","about",JOptionPane.INFORMATION_MESSAGE);
    }

    public void selectedTabChanged(){
        if (tabbedPane.getSelectedIndex() == 0)
            controller.setPlainText(plainTextPane.getText());
        else
            plainTextPane.setText(controller.getPlainText());

        resetUndo();
    }
}

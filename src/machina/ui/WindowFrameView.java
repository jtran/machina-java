package machina.ui;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import machina.IExp;
import machina.IObserver;
import machina.frame.EvalFrame;

public class WindowFrameView extends JPanel implements IObserver<EvalFrame> {

	private static final long	serialVersionUID = 20091004L;
	
	WindowFrameController controller;
	EvalFrame frame;
	JLabel lblExp;
	JLabel lblResult;
	
	public WindowFrameView(WindowFrameController controller, EvalFrame frame) {
		this.controller = controller;
		this.frame = frame;
		
		lblExp = new JLabel("", JLabel.LEFT);
		setExp(frame.getExp());
		add(lblExp);
		
		lblResult = new JLabel("", JLabel.RIGHT);
		lblResult.setForeground(new Color(0, 0, 0xC0));
		setResult(frame.getResult());
		add(lblResult);
	}
	
	public void setExp(IExp e) {
		lblExp.setText(e.toString());
	}
	
	public void setResult(IExp result) {
		lblResult.setText(result.toString());
	}

	public void observedUpdate(EvalFrame frame) {
		setExp(frame.getExp());
		setResult(frame.getResult());
	}
	
}

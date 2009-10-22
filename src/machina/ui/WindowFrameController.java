package machina.ui;

import machina.Evaluator;
import machina.frame.EvalFrame;

public class WindowFrameController {

	private Evaluator evaluator;
	private EvalFrame frame;
	private WindowFrameView view;
	
	public WindowFrameController(Evaluator evaluator, EvalFrame frame) {
		this.evaluator = evaluator;
		this.frame = frame;
		this.view = new WindowFrameView(this, frame);
		frame.registerObserver(view);
	}

	public Evaluator getEvaluator() {
		return evaluator;
	}

	public EvalFrame getFrame() {
		return frame;
	}

	public WindowFrameView getView() {
		return view;
	}
	
}

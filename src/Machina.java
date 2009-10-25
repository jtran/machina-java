

import static javax.swing.JFrame.EXIT_ON_CLOSE;

import javax.swing.JFrame;

import machina.EvalCtx;
import machina.Evaluator;
import machina.IExp;
import machina.IObserver;
import machina.Symbol;
import machina.exp.ApplyExp;
import machina.exp.FnExp;
import machina.exp.IntExp;
import machina.exp.ListExp;
import machina.exp.PrimExp;
import machina.exp.SymExp;
import machina.frame.EvalFrame;
import machina.ui.WindowFrameController;
import machina.ui.WindowFrameView;

public class Machina implements IObserver<IExp> {
	
	Evaluator evalr = Evaluator.getInstance();
	
	WindowFrameController controller;
	JFrame wnd;
	
	private Machina() {}
	
	public static void main(String[] args) {
		new Machina().run();
	}
	
	public void run() {
		// Model
		// Exp
		//IExp ans = new IntExp(42);
		IExp id = new FnExp(new Symbol("x"), new SymExp(new Symbol("x")));
		IExp e = new ApplyExp(id, new IntExp(42));
//		IExp e = new ApplyExp(new PrimExp("+"), new ListExp(new IntExp(40), new IntExp(2)));
		// Frame
		EvalCtx emptyCtx = new EvalCtx();
		EvalFrame frame = new EvalFrame(emptyCtx, e);
		
		// Controller
		controller = new WindowFrameController(evalr, frame);
		
		// View
		wnd = new JFrame("Machina");
		wnd.setDefaultCloseOperation(EXIT_ON_CLOSE);
		wnd.add(controller.getView());
		wnd.pack();
		wnd.setVisible(true);
		
		// Hook into evaluation steps.
		evalr.registerObserver(this);
		
		// Evaluate
		evalr.force(frame);
	}

	public void observedUpdate(IExp observable) {
		//System.out.println("observed " + observable);
		wnd.pack();
	}
	
	

}

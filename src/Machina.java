

import static javax.swing.JFrame.EXIT_ON_CLOSE;

import javax.swing.JFrame;

import machina.EvalCtx;
import machina.Evaluator;
import machina.IExp;
import machina.Symbol;
import machina.exp.ApplyExp;
import machina.exp.FnExp;
import machina.exp.IntExp;
import machina.exp.ListExp;
import machina.exp.PrimExp;
import machina.exp.SymExp;
import machina.frame.EvalFrame;
import machina.ui.WindowFrameController;

public class Machina {
	
	private Machina() {}
	
	public static void main(String[] args) {
		// Model
		// Exp
		Evaluator evalr = Evaluator.getInstance();
		//IExp ans = new IntExp(42);
		IExp id = new FnExp(new Symbol("x"), new SymExp(new Symbol("x")));
		IExp e = new ApplyExp(id, new IntExp(42));
//		IExp e = new ApplyExp(new PrimExp("+"), new ListExp(new IntExp(40), new IntExp(2)));
		// Frame
		EvalCtx emptyCtx = new EvalCtx();
		EvalFrame frame = new EvalFrame(emptyCtx, e);
		
		// Controller
		WindowFrameController c = new WindowFrameController(evalr, frame);
		
		// View
		JFrame wnd = new JFrame("Machina");
		wnd.setDefaultCloseOperation(EXIT_ON_CLOSE);
		wnd.add(c.getView());
		wnd.pack();
		wnd.setVisible(true);
		
		// Evaluate
		evalr.force(frame);
	}

}

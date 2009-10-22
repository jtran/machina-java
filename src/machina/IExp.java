package machina;


public interface IExp {

	IExp evalStep(EvalCtx ctx);
	
	boolean isNormalForm();
	boolean isWeakHeadNormalForm();
	
}

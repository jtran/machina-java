# Concept

Evaluation is done in tiny steps.  This way, something can display
evaluation as it progresses.

This is using the Model-View-Controller pattern, where the model is
the code being executed.  You could theoretically have many different
views of your code, or skins.

Right now, this is using lazy evaluation and ultra-parallelization
(simulated for now).  But this is not fundamental to the design.

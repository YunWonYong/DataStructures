package tree.binary.traversal.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import tree.binary.traversal.test.iterative.IterativeTraversalTest;
import tree.binary.traversal.test.iterative.IterativeTraversalTest2;
import tree.binary.traversal.test.iterative.IterativeTraversalTest3;
import tree.binary.traversal.test.iterative.IterativeTraversalTest4;
import tree.binary.traversal.test.recursive.RecursiveTraversalTest;
import tree.binary.traversal.test.recursive.RecursiveTraversalTest2;
import tree.binary.traversal.test.recursive.RecursiveTraversalTest3;
import tree.binary.traversal.test.recursive.RecursiveTraversalTest4;

@RunWith(Suite.class)
@SuiteClasses({
	IterativeTraversalTest.class,
	IterativeTraversalTest2.class,
	IterativeTraversalTest3.class,
	IterativeTraversalTest4.class, 
	RecursiveTraversalTest.class,
	RecursiveTraversalTest2.class,
	RecursiveTraversalTest3.class,
	RecursiveTraversalTest4.class
})
public class AllTests {

}

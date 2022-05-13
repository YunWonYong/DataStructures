package linkedLists.single.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	AddTest.class, 
	AddIndexTest.class,  
	IndexOfTest.class,
	SetTest.class,
	RemoveTest.class,
	GetTest.class
})
public class TestSuite {
}

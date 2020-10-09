package objectHolder;

public class tester {
	public static void main(String[] args) {
		String test[] = {"bla","1231231231","bob","bob's life","bob's publisher","2002"};
		String test1[] = {"bla","1231231231","not Bob anymore","bob's life","bob's publisher","2002"};
		String test2[] = {"bla","loser","","","","2002"};
		String test3[] = {"bla","444444444","","","","2002"};
		String test4[] = {"","","","","",""};
		Database database = new Database();
		database.insert(test);
		System.out.print(database.search(test));
		database.editDatabase(test1);
		System.out.print(database.search(test2));
		System.out.print("massprint\n");
		System.out.print(database.insert(test2));
		System.out.print(database.search(test4));
		System.out.print("test\n");
		database.delete(test4);
		System.out.print(database.search(test4));
		System.out.print("Done"+" Test");
	}

}

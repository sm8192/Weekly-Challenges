import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        String[] builds = new String[] {"a", "b", "c", "d", "e", "f"};
        String[][] dependencies = new String[][]{{"a", "d"}, {"f", "b"}, {"b", "d"}, {"f", "a"}, {"d", "c"}};
        int length = builds.length;
        String[] results = new String[length];
        int index = 0;

        dependencies = Main.dependencySorter(dependencies);

        for(int i = 0; i < dependencies.length; i++)
        {
            if(!Main.isInResults(results, dependencies[i][0]))
            {
                results[index] = dependencies[i][0];
                index++;
            }
        }

        for (String build: builds
             ) {
            if(!Main.isInResults(results, build))
            {
                results[index] = build;
                index++;
            }
        }

        for (String result: results
             ) {
            System.out.println(result);
        }
    }

    static boolean isInResults(String[] results, String item)
    {
        for (String result: results
             ) {
            if(item.equals(result))
            {
                return true;
            }
        }
        return false;
    }

    static String[][] dependencySorter(String[][] dependencies)
    {
        System.out.println("Begin Sort");
        int loops = 0;
        boolean sorted = true;
        do {
            sorted = true;
            for(int i = 0; i < dependencies.length; i++)
            {
                for(int j = i; j < dependencies.length; j++)
                {
                    if(dependencies[i][0].equals(dependencies[j][1]))
                    {
                        System.out.println("Swapping");
                        String[] temp = dependencies[j];
                        dependencies[j] = dependencies[i];
                        dependencies[i] = temp;
                        sorted = false;
                    }
                    System.out.println("Inner");
                }
                System.out.println("Outer");
            }
        } while(!sorted && (loops < dependencies.length*2));
        if(loops >= dependencies.length*2)
            System.out.println("Error!");

        return dependencies;
    }



}

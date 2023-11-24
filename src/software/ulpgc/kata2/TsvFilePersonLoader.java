package software.ulpgc.kata2;

import java.io.*;
import java.util.List;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

public class TsvFilePersonLoader implements PersonLoader{
    private File file;

    private TsvFilePersonLoader(File file) {
        this.file = file;
    }

    public TsvFilePersonLoader with(String file) {
        return new TsvFilePersonLoader(new File(file));
    }

    @Override
    public List<Person> load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return load(reader);
        }
         catch (IOException e) {
            return emptyList();
        }
    }

    private List<Person> load(BufferedReader reader) {
        return reader.lines()
                .skip(1)
                .map(line->toPerson(line.split("\t")))
                .collect(toList());
    }

    private Person toPerson(String[] split) {
        return new Person(
                parseInt(split[0]),
                parseDouble(split[1]),
                parseDouble(split[2])
        );
    }
}

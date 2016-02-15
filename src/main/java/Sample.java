package main.java;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by nlloyd on 2/4/16.
 */
public class Sample {
    public static void main(String[] args) throws Exception{
        bigSum();

    }

    public static void stairs(){
        Integer in = new Scanner(System.in).nextInt();
        IntStream.range(1, in + 1).forEach(x -> {
            System.out.println(
                    Collections.nCopies(in - x, " ").stream()
                            .collect(Collectors.joining()).concat(
                            Collections.nCopies(x, "#").stream().collect(Collectors.joining())
                    ));
        });
    }

    public static void getGcd(){
        Integer runs = 4;
//        List<String> ins = Arrays.asList(
//                "2 2 3 2 5 3",
//                "3 2 5 3 11 1",
//                "2 2 3 3 5 4 7 6 19 18",
//                "3 10 5 15"
//        );
        List<String> ins = Arrays.asList(
                "7 2",
                "2 2 7 1"
        );

        List<Map<Integer, Integer>> facs = new LinkedList<>();
        ins.stream().forEach(m ->
                facs.add(Arrays.asList(m.split(" ")).stream()
                        .map(Integer::parseInt)
                        .collect(new Collector<Integer, Map<Integer, Integer>, Map<Integer, Integer>>() {
                            private Integer curr = null;

                            @Override
                            public Supplier<Map<Integer, Integer>> supplier() {
                                return HashMap::new;
                            }

                            @Override
                            public BiConsumer<Map<Integer, Integer>, Integer> accumulator() {
                                return (m, i) -> {
                                    if(curr == null) {
                                        curr = i;
                                    } else {
                                        m.put(curr, i);
                                        curr = null;
                                    }
                                };
                            }

                            @Override
                            public BinaryOperator<Map<Integer, Integer>> combiner() {
                                return (l, r) -> {
                                    l.putAll(r);
                                    return l;
                                };
                            }

                            @Override
                            public Function<Map<Integer, Integer>, Map<Integer, Integer>> finisher() {
                                return f -> f;
                            }

                            @Override
                            public Set<Characteristics> characteristics() {
                                return EnumSet.of(Characteristics.UNORDERED);
                            }
                        })));

        Map<Integer, Integer> result = new HashMap<>();
        facs.sort((a, b) -> Integer.compare(b.size(), a.size()));
        facs.get(0).entrySet().forEach(e -> {
            if(facs.stream().allMatch(m -> m.containsKey(e.getKey()))) {
                result.put(
                        e.getKey(),
                        facs.stream()
                                .map(m -> m.get(e.getKey()))
                                .collect(Collectors.toList()).stream()
                                .min(Integer::compareTo).orElse(1));
            }
        });
        String rez = result.entrySet().stream().map(m -> String.join(" ", m.getKey().toString(), m.getValue().toString())).collect(Collectors.joining(" "));
        System.out.println(rez);
    }

    public static void bigSum(){
        //reads the number of longs given by the first input and prints the sum
        Scanner scanner = new Scanner(System.in);
        Long sum = Stream.generate(scanner::next).limit(scanner.nextLong()).mapToLong(Long::parseLong).sum();
        System.out.println(sum);

    }

}


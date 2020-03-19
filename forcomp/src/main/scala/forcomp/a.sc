
val w = "Scala"

w.toLowerCase.toSeq.sorted.groupBy(identity)

w.toLowerCase.toSeq.groupBy(identity).map({case (c, l) => (c, l.length)}).toList.sorted

val n = 3
val x = 1 to n

print(x.toList)

import forcomp.Anagrams._

dictionaryByOccurrences(List(('a', 1), ('e', 1), ('t', 1)))

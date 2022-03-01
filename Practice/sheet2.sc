/// PART 1
def isVowel(ch: Char) = ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
isVowel('e')
// OR
def isVowel1(ch: Char) = "aeiou".contains(ch)
isVowel('b')

// PART 2
def vowels(s: String) = {
  var res = ""
  for (ch <- s) {
//    if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
//    res += ch
    if(isVowel(ch)) res += ch
  }
  res
}
vowels("seibc")
// OR
def vowels2(s: String) =
  for (ch <- s if isVowel(ch)) yield ch

vowels2("sunil")

// PART 3
def vowels3(s: String): String = {
  if (s.length == 0) ""
  else {
    val ch = s(0)
    val rest = vowels3(s.substring(1))
    if (isVowel(ch)) ch + rest else rest
  }
}
vowels3("abcdeoucdi")

def vowels4(s: String) = {
  var i = 0
  var result = ""
  while(i < s.length) {
    val ch = s(i)
    if (isVowel(ch)) result += ch
    i += 1
  }
  result
}
vowels4("Nicaragua")

// PART 4
def checkVowel(ch: Char, vowelChars: String) = vowelChars.contains(ch)

def FindVowel(s: String, vowelChars: String = "aeiou", ignoreCase: Boolean = true) =
  for (ch <- (if(ignoreCase) s.toLowerCase else s) if checkVowel(ch, vowelChars)) yield ch

FindVowel("SUNAEIousd")
// OR

def showVowels(s: String, vowelChars: String = "aeiou", ignoreCase: Boolean = true): String =
  if(ignoreCase) showVowels(s.toLowerCase, vowelChars, false)
  else for (ch <- s if checkVowel(ch, vowelChars)) yield ch

showVowels("August")
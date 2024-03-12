package testcase

import fastparse.{P, *}
import fastparse.MultiLineWhitespace.*

object Parsers {

  private def wholeNumber[u: P]: P[Long] = {
    CharIn("0-9").rep(1).!.map(_.toLong)
  }

  def long[u: P]: P[Long] = {
    CharIn("+\\-").? ~~ wholeNumber
  }

  def allLong[u: P]: P[Long] = {
    P(Start ~ long ~ End)
  }
  
  def parseRule[RESULT](
    pi: ParserInput,
    rule: P[?] => P[RESULT],
    withVerboseFailures: Boolean = false
  ): Parsed[RESULT] = {
    fastparse.parse[RESULT](pi, rule(_), withVerboseFailures)
  }
}

@main def parseAndPrint(number: String): Unit = {
  val input = ParserInput.fromString(number)
  val result = Parsers.parseRule[Long](input, Parsers.allLong(_), true)
  if result.isSuccess then 
    println(result.get.value.toInt) else println("Not And Integer")
}


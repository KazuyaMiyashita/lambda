package lambda

sealed trait Term

case class Variable(name: String) extends Term
case class Lambda(variable: Variable, term: Term) extends Term
case class Applicate(lh: Term, rh: Term) extends Term

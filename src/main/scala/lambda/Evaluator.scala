package lambda

object Evaluator {

  def evalOnce(term: Term, environment: Environment): Option[(Term, Environment)] = {
    term match {
      case v:Variable => ???
      case Lambda(variable, term) => ???
      case Applicate(lh, rh) => ???
    }
  }

  def eval(term: Term): Term = {
    def proc(term: Term, environment: Environment): (Term, Environment) = {
      evalOnce(term, environment) match {
        case Some((nextTerm, nextEnvironment)) => proc(nextTerm, nextEnvironment)
        case None => (term, environment)
      }
    }
    proc(term, Environment.empty)._1
  }

}


case class Environment(mapping: Map[Variable, Term], parent: Option[Environment]) {

  def find(variable: Variable): Option[Term] = {
    mapping.get(variable).orElse {
      parent.flatMap(_.find(variable))
    }
  }

  def register(variable: Variable, term: Term): Environment = {
    copy(mapping = mapping + (variable -> term))
  }

}

object Environment {
  def empty = new Environment(Map.empty, None)
}

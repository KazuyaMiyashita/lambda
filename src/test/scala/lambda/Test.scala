package lambda

import org.scalatest._
import lambda.syntax._

class Test extends FunSuite with Matchers {

  def eval(term: Term): Term = {
    new Evaluator().eval(term)
  }

  test("succ zero == one") {

    val id = x ->: x
    val value = y

    (id * value) shouldEqual value

  }

  test("succ zero == one") {

    val succ = n ->: s ->: z ->: s * (n * s * z)
    val zero = s ->: z ->: z
    val one = s ->: z ->: s * z

    (succ * zero) shouldEqual one

    // ☝️ 今日の目標

  }

}


/*
n ->: s ->: z ->: s * (n * s * z)

Lambda(
  Variable(n),
  Lambda(
    Variable(s),
    Lambda(
      Variable(z),
      Applicate(
        Variable(s),
        Applicate(
          Applicate(
            Variable(n),
            Variable(s)
          ),
          Variable(z)
        )
      )
    )
  )
)
*/

/*
id = x ->: x
Lambda(
  Variable(x),
  Variable(x)
)

id * (id * y)

Applicate(
  Lambda(
    Variable(x),
    Variable(x)
  ),
  Applicate(
    Lambda(
      Variable(x),
      Variable(x)
    ),
    Variable(y)
  )
)
*/

/*
succ = n ->: s ->: z ->: s * (n * s * z)
zero = s ->: z ->: z
one  = s ->: z ->: s * z

succ * zero
  = (n ->: s ->: z ->: s * (n * s * z)) zero
  = s ->: z ->: s * (zero * s * z)
  = s ->: z ->: s * ((s1 ->: z1 ->: z1) * s * z)
  = s ->: z ->: s * ((z1 ->: z1) * z)
  = s ->: z ->: s * z
  = one

Applicate(
  Lambda(
    Variable(n),
    Lambda(
      Variable(s),
      Lambda(
        Variable(z),
        Applicate(
          Variable(s),
          Applicate(
            Applicate(
              Variable(n),
              Variable(s)
            ),
            Variable(z)
          )
        )
      )
    )
  ),
  Lambda(
    Variable(s),
    Lambda(
      Variable(z),
      Variable(z)
    )
  )
)

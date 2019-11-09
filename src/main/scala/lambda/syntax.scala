package lambda

object syntax {

  implicit class TermOps(self: Term) {
    def ->:(v: Variable) = Lambda(v, self)
    def *(t: Term) = Applicate(self, t)
  }

  def a = Variable("a")
  def b = Variable("b")
  def c = Variable("c")
  def d = Variable("d")
  def e = Variable("e")
  def f = Variable("f")
  def g = Variable("g")
  def h = Variable("h")
  def i = Variable("i")
  def j = Variable("j")
  def k = Variable("k")
  def l = Variable("l")
  def m = Variable("m")
  def n = Variable("n")
  def o = Variable("o")
  def p = Variable("p")
  def q = Variable("q")
  def r = Variable("r")
  def s = Variable("s")
  def t = Variable("t")
  def u = Variable("u")
  def v = Variable("v")
  def w = Variable("w")
  def x = Variable("x")
  def y = Variable("y")
  def z = Variable("z")

}

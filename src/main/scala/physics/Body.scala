import java.awt.Color


object Body {
  private val G = 6.673e-11 // gravitational constant

  private val solarmass = 1.98892e30
}

class Body(var rx: Double, var ry: Double // holds the cartesian positions
           , var vx: Double, var vy: Double // velocity components
           , var mass: Double // mass
           , var color: Color // color (for fun)
          ) // create and initialize a new Body
{
  var fx = .0
  var fy = .0 // force components

  // update the velocity and position using a timestep dt
  def update(dt: Double): Unit = {
    vx += dt * fx / mass
    vy += dt * fy / mass
    rx += dt * vx
    ry += dt * vy
  }

  // returns the distance between two bodies
  def distanceTo(b: Body): Double = {
    val dx = rx - b.rx
    val dy = ry - b.ry
    Math.sqrt(dx * dx + dy * dy)
  }

  // set the force to 0 for the next iteration
  def resetForce(): Unit = {
    fx = 0.0
    fy = 0.0
  }

  // compute the net force acting between the body a and b, and
  // add to the net force acting on a
  def addForce(b: Body): Unit = {
    val a = this
    val EPS = 3E4
    // softening parameter (just to avoid infinities)
    val dx = b.rx - a.rx
    val dy = b.ry - a.ry
    val dist = Math.sqrt(dx * dx + dy * dy)
    val F = (Body.G * a.mass * b.mass) / (dist * dist + EPS * EPS)
    a.fx += F * dx / dist
    a.fy += F * dy / dist
  }

  // convert to string representation formatted nicely
  override def toString: String = "" + rx + ", " + ry + ", " + vx + ", " + vy + ", " + mass
}
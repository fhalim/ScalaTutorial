package net.fawad.learningscala

import resource.Resource

object Disposal {
  type Unlockable = {
    def lock()
    def unlock()
  }

  implicit def unlockResource[A <: Unlockable] = new Resource[A] {
    override def close(r: A) = r.unlock()
    override def open(r: A): Unit = r.lock()
  }

  type Shutdownable = {def shutdown()}

  implicit def shutdownResource[A <: Shutdownable] = new Resource[A] {
    override def close(r: A) = r.shutdown()
  }
}

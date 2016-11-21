package annotating

/**
 * Inheritance must be used only where the subclass is substitutable
 * in place of the base class. For most other purposes, <b>delegation</b>
 * is better than inheritance from pure code reuse point of view.
 *
 * Groovy makes delegation easy so we can make the proper design choice.
 *
 * At compile time, Groovy examines the class and brings in methods from the delegated
 * classes <b>only if these methods don't already exist</b>. This is a first-come, first-serve
 * situation.
 */
class A {
    def task() {println ":A:task"}
    def create() {println ":A:create"}
    def complete() {println ":A:complete"}
}

class B {
    def task() {println ":B:task"}
    def rest() {println ":B:rest"}
}

class C {
    def complete() {println ":C:complete"}
}

class Delegation {
    @Delegate C c = new C()
    @Delegate B b = new B()
    @Delegate A a = new A()
    def rest() {println ":D:rest"}
}

Delegation d = new Delegation()
d.task()
d.create()
d.complete()
d.rest()
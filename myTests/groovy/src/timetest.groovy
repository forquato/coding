import groovy.time.*

def expiredDate = "2017-11-22 12:06:56.463"
def insertedDate = "2017-11-22 11:56:56.463"

def dateExpired = Date.parse("yyyy-MM-dd HH:mm:ss", expiredDate)
def dateInserted =Date.parse("yyyy-MM-dd HH:mm:ss", insertedDate)


println(dateExpired)
println(dateExpired.getTime())

println(dateInserted)
println(dateInserted.getTime())



def diff = dateExpired.getTime()/1000-dateInserted.getTime()/1000

println(diff)


def daff = TimeCategory.minus(dateExpired, dateInserted)

println(daff)

//def expiredInMinutes = context.expand( '${#TestCase#expiredInMinutes}' ).toInteger()
//assert (diff.minutes == expiredInMinutes)


# Dijkstra algorithm

```
r: starting point

A <- {r}
pivot <- r
pi(r) <- 0

forall x != r:
    pi(r) <- inf

do n-1 times:
    forall y not in A and successor of pivot:
        if pi(pivot) + w(pivot, y) < pi(y):
            pi(y) <- pi(pivot) + w(pivot, y)
            father(y) <- pivot

    z <- min(_ forall _ not in A)
    pivot <- z
    A <- A + z

here:
forall e in g:
    pi(e) = distance from r to e
    father(e) = step ? - 1 in the 
```

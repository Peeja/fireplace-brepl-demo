## The issue

I can't connect to a browser-connected REPL using fireplace.vim's `:Piggieback`.

## The steps I'm following

1. Check out this repo.

2. `lein go` (This runs `cljsbuild auto` and the ring server.)

3. Open the page in a browser to connect it to the REPL: http://localhost:7777/

4. `vim src/cljs/fireplace-brepl-demo/core.cljs`

5. In Vim, `:Piggieback fireplace-brepl-demo.core/repl-env`

  * For me, this fails:

    ```
    IllegalStateException Can't change/establish root binding of: *cljs-repl-options* with set  clojure.lang.Var.set (Var.java:221)
    ```

6. Note the port number from the `lein go` output and try `:Piggieback <port-number>` instead.

  * For me, this fails with the same error.

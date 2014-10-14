# Quil Sketches

## Installation

Install leiningen and follow installation instructions for quil

## Usage

In `lein repl` run::

    (require 'hello-quil.core)
    (use :reload 'hello-quil.dynamic)

Using vim, install vim-fireplace and -

Open a core.clj file and use::

    :Console

This will take some time. If you setup nailgun and configure vim-clojure to
connect to it, you can get better load time

Once the REPL has started use::

    :Require

Now the animation will be running. Open dynamic.clj and use::

    :Require

As one edits dynamic.clj, :Require will update the running animation with
the new code

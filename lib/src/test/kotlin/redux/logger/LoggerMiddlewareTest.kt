package redux.logger

import org.jetbrains.spek.api.Spek
import redux.Middleware
import redux.Store
import redux.logger.LoggerMiddlewareTest.Actions.Dec
import redux.logger.LoggerMiddlewareTest.Actions.Inc

/*
 * Copyright (C) 2016 Michael Pardo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

class LoggerMiddlewareTest : Spek({

    val reducer = { state: Int, action: Any ->
        when (action) {
            is Inc -> state + 1
            is Dec -> state - 1
            else -> state
        }
    }

    describe("LoggerMiddleware") {

        describe("create") {

            it("creates a logger middleware") {
                // TODO: This test is mostly for function type checking at this point.
                val store = Store.create(reducer, 0, Middleware.apply(LoggerMiddleware.create()))
            }

        }

    }

}) {
    sealed class Actions {
        class Inc : Actions()
        class Dec : Actions()
    }
}

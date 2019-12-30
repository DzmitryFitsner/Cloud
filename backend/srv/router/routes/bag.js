/*eslint no-unused-vars: 0, no-shadow: 0, new-cap: 0*/
/*eslint-env node, es6 */
"use strict";

const express = require("express");

const dbClass = require(global.__base + "utils/dbClass");


function _prepareObject(oBag, req) {
		oBag.changedBy = "DebugUser";
    return oBag;
}


module.exports = () => {
    const app = express.Router();

    app.get("/", async (req, res, next) => {
        const logger = req.loggingContext.getLogger("/Application");
        logger.info('bag get request');
        let tracer = req.loggingContext.getTracer(__filename);
        tracer.entering("/bag", req, res);

        try {
            tracer.exiting("/bag", "Bag Get works");
            res.type("application/json").status(201).send(JSON.stringify({text: "Bag Get works"}));
        } catch (e) {
            tracer.catching("/bag", e);
            next(e);
        }
    });

    app.post("/", async (req, res, next) => {
        try {
            const db = new dbClass(req.db);

            const oUser = _prepareObject(req.body, req);
				    oUser.usid = await db.getNextval("usid");

            const sSql = "INSERT INTO \"BAG\" VALUES(?,?)";
						const aValues = [ oBag.usid, oBag.name ];

						console.log(aValues);
						console.log(sSql);
            await db.executeUpdate(sSql, aValues);

            res.type("application/json").status(201).send(JSON.stringify(oBag));
        } catch (e) {
            next(e);
        }
    });

    app.put("/", async (req, res, next) => {
        try {
            const db = new dbClass(req.db);

            const oUser = _prepareObject(req.body, req);
            const sSql = "UPDATE \"BAG\" SET \"NAME\" = ? WHERE \"USID\" = ?";
						const aValues = [ oUser.name, oBag.usid ];

            await db.executeUpdate(sSql, aValues);

            res.type("application/json").status(200).send(JSON.stringify(oUser));
        } catch (e) {
            next(e);
        }
    });

    return app;
};

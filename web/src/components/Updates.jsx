import React, { useState, useEffect } from 'react';

function Updates() {
    const [data, setData] = useState(null);
    const userId = "7acbd6c8-7eeb-40ee-8fec-af9f2a79ce06";

    useEffect(() => {
        fetch(`http://localhost:8080/api/users/${userId}/communities`)
            .then(response => response.json())
            .then(json => setData(json))
            .catch(error => console.error(error));
    }, []);

    return (
        <>
            DELETE ME
            {data ? <pre>{JSON.stringify(data, null, 2)}</pre> : 'Loading...'}
            DELETE ME

            <div className="d-flex justify-content-evenly">
                <div className="list-group w-25 p-2">
                    <p>Updates in communities I started:</p>
                    <a href="#" className="list-group-item list-group-item-action list-group-item-light"
                       aria-current="true">
                        <div className="d-flex w-100 justify-content-between">
                            <h5 className="mb-1">Post 1</h5>
                            <small><span className="badge text-bg-primary rounded-pill"><i
                                className="bi bi-hand-thumbs-up-fill"></i> 17</span></small>
                        </div>
                        <small>Replies: 3</small>
                    </a>
                    <a href="#" className="list-group-item list-group-item-action list-group-item-light">
                        <div className="d-flex w-100 justify-content-between">
                            <h5 className="mb-1">Post 2</h5>
                            <small className="text-body-secondary"><span className="badge text-bg-primary rounded-pill"><i
                                className="bi bi-hand-thumbs-up-fill"></i> 10</span></small>
                        </div>
                        <small>Replies: 1</small>
                    </a>
                    <a href="#" className="list-group-item list-group-item-action list-group-item-light">
                        <div className="d-flex w-100 justify-content-between">
                            <h5 className="mb-1">Post3</h5>
                            <small className="text-body-secondary"><span className="badge text-bg-primary rounded-pill"><i
                                className="bi bi-hand-thumbs-up-fill"></i> 1</span></small>
                        </div>
                        <small>Replies: 0</small>
                    </a>
                    <button type="button" className="btn btn-outline-primary d-flex justify-content-end">List all
                        communities I started
                    </button>
                </div>
                <div className="list-group w-75 p-2">
                    <p>Updates from communities I'm a member of:</p>
                    <a href="#" className="list-group-item list-group-item-action list-group-item-light"
                       aria-current="true">
                        <div className="d-flex w-75 justify-content-between">
                            <h5 className="mb-1">Post 1</h5>
                            <p className="mb-1">in</p>
                            <h7 className="mb-1"><i
                                className="bi bi-people-fill"></i> Web design maniacs</h7>
                        </div>
                    </a>
                    <a href="#" className="list-group-item list-group-item-action list-group-item-light"
                       aria-current="true">
                        <div className="d-flex w-75 justify-content-between">
                            <h5 className="mb-1">Post 2</h5>
                            <p className="mb-1">in</p>
                            <h7 className="mb-1"><i
                                className="bi bi-people-fill"></i> Web design maniacs</h7>
                        </div>
                    </a>
                    <a href="#" className="list-group-item list-group-item-action list-group-item-light"
                       aria-current="true">
                        <div className="d-flex w-75 justify-content-between">
                            <h5 className="mb-1">Post 3</h5>
                            <p className="mb-1">in</p>
                            <h7 className="mb-1"><i
                                className="bi bi-people-fill"></i> Web design maniacs</h7>
                        </div>
                    </a>
                    <button type="button" className="btn btn-outline-primary d-flex justify-content-end">List all
                        communities I'm a member of
                    </button>
                </div>
            </div>
        </>
    )
}

export default Updates
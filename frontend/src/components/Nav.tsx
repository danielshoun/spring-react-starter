import {Link, useHistory} from "react-router-dom";
import {useSession} from "../context";
import csrfFetch from "../utils/csrfFetch";

export default function Nav() {
    const history = useHistory();
    const {session, setSession} = useSession();

    async function handleLogout() {
        const res = await csrfFetch("/api/v1/auth/logout", {
            method: "DELETE"
        })
        if (res.ok) {
            setSession && setSession(null);
            history.push("/")
        }
    }

    return (
        <div className="nav">
            <Link className="nav-link" to="/">Home</Link>
            {session ?
                <>
                    <Link className="nav-link" to="/dashboard">Dashboard</Link>
                    <Link className="nav-link" to="/" onClick={handleLogout}>Logout</Link>
                </> :
                <>
                    <Link className="nav-link" to="/login">Login</Link>
                    <Link className="nav-link" to="/register">Register</Link>
                </>
            }
        </div>
    );
}
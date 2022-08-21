import React, { useEffect, useState } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import { Container, Paper, Button } from '@material-ui/core';

const useStyles = makeStyles((theme) => ({
    root: {
        '& > *': {
            margin: theme.spacing(1),

        },
    },

}));

export default function Professor() {
    const paperStyle = { padding: '50px 20px', width: 600, margin: "20px auto" }
    const [name, setName] = useState('')
    const [taughtSubject, setTaughtSubject] = useState('')
    const [course, setCourse] = useState('')


    const [professor, setProfessor] = useState([])
    const classes = useStyles();

    const handleClick = (e) => {
        e.preventDefault()
        const professor = { name, taughtSubject, course }
        console.log(professor)
        fetch("http://localhost:8080/professor/add", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(professor)

        }).then(() => {
            console.log("New Professor added")
        })
    }

    useEffect(() => {
        fetch("http://localhost:8080/professor/getAll")
            .then(res => res.json())
            .then((result) => {
                setProfessor(result);
            }
            )
    }, [])
    return (

        <Container>
            <Paper elevation={3} style={paperStyle}>
                <h1 style={{ color: "black" }}>Add Professor</h1>

                <form className={classes.root} noValidate autoComplete="off">

                    <TextField id="outlined-basic" label="Professor Name" variant="outlined" fullWidth
                        value={name}
                        onChange={(e) => setName(e.target.value)}
                    />
                    <TextField id="outlined-basic" label="Professor Course" variant="outlined" fullWidth
                        value={course}
                        onChange={(e) => setCourse(e.target.value)}
                    />
                    <TextField id="outlined-basic" label="Professor Taught Subject" variant="outlined" fullWidth
                        value={taughtSubject}
                        onChange={(e) => setTaughtSubject(e.target.value)}
                    />
                    <Button variant="contained" color="secondary" onClick={handleClick}>
                        Submit
                    </Button>
                </form>

            </Paper>
            <h1>Professor</h1>

            <Paper elevation={3} style={paperStyle}>

                {professor.map(professor => (
                    <Paper elevation={6} style={{ margin: "10px", padding: "15px", textAlign: "left" }} key={professor.code}>
                        Name: {professor.name}<br />
                        Code: {professor.code}<br />
                        Course: {professor.course}<br />
                        TaughtSubject: {professor.taughtSubject}<br />

                    </Paper>
                ))
                }


            </Paper>



        </Container>
    );
}